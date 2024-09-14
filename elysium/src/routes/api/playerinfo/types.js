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
