<script>
    /**
     * @type {"macro" | "mini" | "micro"} - This prop accepts a heading type
     */
    export let htype = "macro";
</script>

{#if htype == "macro"}
    <h2 class="mb-2 text-3xl font-bold"><slot>Lorem ipsum</slot></h2>
{:else if htype == "mini"}
    <h3 class="mb-2 text-2xl uppercase tracking-wide">
        <slot>Lorem ipsum</slot>
    </h3>
{:else if htype == "micro"}
    <h4 class="mb-2 text-xl font-light lowercase tracking-tight">
        <slot>Lorem ipsum</slot>
    </h4>
{/if}
