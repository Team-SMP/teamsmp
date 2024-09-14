<script>
    //@ts-ignore
    import MdMenu from "svelte-icons/md/MdMenu.svelte";
    import MdClose from "svelte-icons/md/MdClose.svelte";

    import { navlinks } from "$lib/navlinks";

    let isOpen = false;
</script>

<div class="mx-8 pt-6">
    <!-- Toggle button to open the sheet -->
    <button class="h-8" on:click={() => (isOpen = true)}>
        <MdMenu></MdMenu>
    </button>
</div>

<!-- The sliding sheet -->
<div
    class={`fixed left-0 top-0 z-50 h-full w-screen transform bg-zinc-900 text-white transition-transform duration-300 lg:w-96 ${
        isOpen ? "translate-x-0" : "-translate-x-full"
    }`}
>
    <div class="p-6">
        <button class="h-8" on:click={() => (isOpen = false)}>
            <MdClose></MdClose>
        </button>
        <h2 class="mb-4 mt-3 text-3xl font-bold">Team SMP</h2>
        <div class="ms-4 flex flex-col gap-0.5">
            {#each navlinks as link}
                <span class="block p-1">
                    <a
                        class="text-xl hover:text-sky-500"
                        href={link.url}
                        on:click={() => (isOpen = false)}>{link.name}</a
                    >
                </span>
            {/each}
        </div>
    </div>
</div>
