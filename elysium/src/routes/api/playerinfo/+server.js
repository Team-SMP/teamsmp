import { error, json } from "@sveltejs/kit";

/** @type {import("./$types").RequestHandler} */
export async function GET({ url }) {
    const playerName = String(url.searchParams.get("player"));

    try {
        const rawData = await fetch(
            `http://teamsmp.spdns.eu:33224/v1/player?player=${playerName}`
        );

        if (rawData.status === 404) {
            return json({
                status: "notfound",
                error: {
                    message: `Player ${playerName} wasn't found!`,
                    code: 404,
                },
            });
        }

        if (!rawData.ok) {
            throw error(rawData.status, "Failed to fetch player data");
        }

        const jsonData = await rawData.json();

        const data = {
            status: "found",
            error: {
                message: `Data for ${playerName} was found!`,
                code: 200,
            },
            playerdata: {
                name: jsonData.info.name,
                uuid: jsonData.info.uuid,
                stats: {
                    killdata: {
                        playerkills: jsonData.kill_data.player_kills_total,
                        mobkills: jsonData.kill_data.mob_kills_total,
                        deaths: jsonData.kill_data.deaths_total,
                        weapons: [
                            jsonData.kill_data.weapon_1st.replace(/_/g, " "),
                            jsonData.kill_data.weapon_2nd.replace(/_/g, " "),
                            jsonData.kill_data.weapon_3rd.replace(/_/g, " "),
                        ],
                    },
                    playtime: {
                        total: jsonData.info.playtime,
                        active: jsonData.info.active_playtime,
                        afk: jsonData.info.afk_time,
                    },
                },
            },

            // todo: more data
        };

        return json(data); // Return the JSON data properly
    } catch (err) {
        console.error("Error fetching player data:", err);
        throw error(500, "Internal Server Error");
    }
}
