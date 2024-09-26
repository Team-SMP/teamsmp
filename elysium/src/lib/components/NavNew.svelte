<script>
    // @ts-nocheck

    import * as Sheet from "$lib/components/ui/sheet";
    import Menu from "lucide-svelte/icons/menu";
    import { navlinks } from "$lib/navlinks";
    import { goto } from "$app/navigation";
</script>

<div class="mx-8 pt-6">
    <Sheet.Root>
        <Sheet.Trigger><Menu /></Sheet.Trigger>
        <Sheet.Content side="left">
            <Sheet.Header class="mb-2"
                ><Sheet.Title class="text-3xl font-semibold"
                    >Team SMP</Sheet.Title
                ></Sheet.Header
            >
            <div class="ms-4 flex flex-col gap-0.5">
                {#each navlinks as link}
                    <Sheet.Close class="text-left">
                        <button
                            class="block w-full p-1 text-left text-xl hover:text-sky-500"
                            on:click={goto(link.url)}
                        >
                            {link.name}
                        </button>
                    </Sheet.Close>
                {/each}
            </div>
        </Sheet.Content>
    </Sheet.Root>
</div>
