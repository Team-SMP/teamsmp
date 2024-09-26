<script>
    import MainBlock from "$lib/components/MainBlock.svelte";
    import Para from "$lib/components/Para.svelte";
    import TitleBlock from "$lib/components/TitleBlock.svelte";
    import { Input } from "$lib/components/ui/input";
    import { Button } from "$lib/components/ui/button";

    import { goto } from "$app/navigation";

    let searchterm = "";

    /**
     * @param {string} term
     */
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
            <Input
                class="w-max"
                placeholder="JunglTemple"
                type="text"
                bind:value={searchterm}
            />
            <Button
                variant="secondary"
                disabled={searchterm == ""}
                on:click={() => search(searchterm)}>Search</Button
            >
        </div>
    </div>
</MainBlock>
