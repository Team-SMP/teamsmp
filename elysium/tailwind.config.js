import { fontFamily } from "tailwindcss/defaultTheme";

/** @type {import('tailwindcss').Config} */
export default {
    content: ["./src/**/*.{html,js,svelte,ts}"],

    theme: {
        extend: {
            fontFamily: {
                sans: ['"Geist Sans"', ...fontFamily.sans],
                title: ['"Archivo Black"', '"Geist Sans"', ...fontFamily.sans],
            },
            // animation: {
            //     land: "land 1.5s ease-in-out 0s 1",
            // },
            // keyframes: {
            //     land: {
            //         "0%": { transform: "translateY('-100px')", opacity: "0%" },
            //         "100%": { transform: "translateY('0px')", opacity: "100%" },
            //     },
            // },
        },
    },

    plugins: [require("@tailwindcss/typography")],
};
