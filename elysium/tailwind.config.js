import { fontFamily } from "tailwindcss/defaultTheme";

/** @type {import('tailwindcss').Config} */
export default {
    content: ["./src/**/*.{html,js,svelte,ts}"],

    theme: {
        extend: {
            fontFamily: {
                sans: ['"Geist Sans"', ...fontFamily.sans],
                title: ['"Archivo Black"', '"Geist Sans"', ...fontFamily.sans],
                emoji: ['"Noto Emoji Variable"'],
            },
            backgroundImage: {
                "hero-img": "url('/img/lobby-herobg.png')",
            },
        },
    },

    plugins: [require("@tailwindcss/typography")],
};
