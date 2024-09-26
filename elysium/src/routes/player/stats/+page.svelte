<script>
    import MainBlock from "$lib/components/MainBlock.svelte";
    import TitleBlock from "$lib/components/TitleBlock.svelte";
    import Para from "$lib/components/Para.svelte";
    import { onMount } from "svelte";
    import Sect from "$lib/components/Sect.svelte";
    import Heading from "$lib/components/Heading.svelte";
    import { toast } from "svelte-sonner";

    /**
     * @typedef {Object} PlayerData
     * @property {string} name - Player's name.
     * @property {string} uuid - Player's UUID.
     * @property {Object} stats - Player's statistics.
     * @property {Object} stats.killdata - Kill data statistics.
     * @property {number} stats.killdata.playerkills - Total player kills.
     * @property {number} stats.killdata.mobkills - Total mob kills.
     * @property {number} stats.killdata.deaths - Total deaths.
     * @property {string[]} stats.killdata.weapons - List of weapons used.
     * @property {Object} stats.playtime - Playtime statistics.
     * @property {string} stats.playtime.total - Total playtime.
     * @property {string} stats.playtime.active - Active playtime.
     * @property {string} stats.playtime.afk - AFK time.
     */

    let data = null;
    let loading = true;
    /**
     * @type {string | null}
     */
    let error = null;
    /**
     * @type {PlayerData | null}
     */
    let playerdata = null;

    // Function to extract URL parameter
    /**
     * @param {string} name
     * @returns {string | null}
     */
    function getUrlParameter(name) {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(name);
    }

    onMount(async () => {
        const playername = getUrlParameter("player");

        if (!playername) {
            error = "Player parameter is missing";
            loading = false;
            toast.error("Player parameter missing!", {
                description: "Try searching for a player again.",
            });
            return;
        }

        try {
            const response = await fetch(
                `/api/playerinfo?player=${playername}`
            );
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            const result = await response.json();

            // Check if data is found and assign the data correctly
            if (result.status === "found") {
                playerdata = /** @type {PlayerData} */ result.playerdata;
            } else {
                error = result.error.message || "No data found";
            }
        } catch (err) {
            // @ts-ignore
            error = err.message;
            toast.error("Oops! An error occurred!", {
                description: error ?? "Hmm...",
            });
        } finally {
            loading = false;
        }
    });
</script>

<MainBlock>
    <TitleBlock title="Player stats" subtitle="TEAM SMP" />

    <div id="maintext">
        {#if loading}
            <Para lead><span class="animate-pulse">Loading...</span></Para>
        {:else if error}
            <Para lead>Error: {error}</Para>
        {:else if playerdata}
            <Para lead>{playerdata.name}'s stats:</Para>
            <Sect sectid="playerstats-playtime">
                <Heading htype="macro">Playtime</Heading>
                <ul class="mb-2">
                    <li>Total: {playerdata.stats.playtime.total}</li>
                    <li>Active: {playerdata.stats.playtime.active}</li>
                    <li>AFK Time: {playerdata.stats.playtime.afk}</li>
                </ul>
            </Sect>
            <Sect sectid="playerstats-pvpve">
                <Heading htype="macro">PvP and PvE</Heading>
                <ul class="mb-2">
                    <li>
                        Player kills: {playerdata.stats.killdata.playerkills}
                    </li>
                    <li>Mob kills: {playerdata.stats.killdata.mobkills}</li>
                    <li>Deaths: {playerdata.stats.killdata.deaths}</li>
                </ul>
                <ul class="mb-2">
                    <li>
                        Best weapon: <span class="capitalize"
                            >{playerdata.stats.killdata.weapons.at(0)}</span
                        >
                    </li>
                    <li>
                        Second weapon: <span class="capitalize"
                            >{playerdata.stats.killdata.weapons.at(1)}</span
                        >
                    </li>
                    <li>
                        Third weapon: <span class="capitalize"
                            >{playerdata.stats.killdata.weapons.at(2)}</span
                        >
                    </li>
                </ul>
            </Sect>
        {:else}
            <Para lead>No player data available.</Para>
        {/if}
    </div>
</MainBlock>
