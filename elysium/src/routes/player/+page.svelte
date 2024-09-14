<script>
    import MainBlock from "$lib/components/MainBlock.svelte";
    import Para from "$lib/components/Para.svelte";
    import TitleBlock from "$lib/components/TitleBlock.svelte";

    import { goto } from "$app/navigation";

    let searchterm = "";

    function search(term) {
        if (term != "") {
            goto(`/player/stats?player=${term}`);
        }
    }
</script>

<MainBlock>
    <TitleBlock title="Player stats" subtitle="TEAM SMP" />

    <div id="maintext">
        <Para lead
            >Find anyone's player stats by typing their name in the search bar
            below!</Para
        >
        <div class="flex w-full flex-row gap-1 lg:w-2/3 xl:w-1/2">
            <input
                class="flex-grow rounded-s-md border-none bg-zinc-200 dark:bg-zinc-800"
                placeholder="JunglTemple"
                type="text"
                bind:value={searchterm}
            />
            <button
                class="rounded-e-md bg-zinc-200 px-3 disabled:cursor-not-allowed disabled:bg-zinc-300 disabled:text-zinc-500 dark:bg-zinc-800 disabled:dark:bg-zinc-900 disabled:dark:text-zinc-400"
                disabled={searchterm == ""}
                on:click={() => search(searchterm)}>Search</button
            >
        </div>
    </div>
</MainBlock>
