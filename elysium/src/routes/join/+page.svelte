<script>
    import MainBlock from "$lib/components/MainBlock.svelte";
    import TitleBlock from "$lib/components/TitleBlock.svelte";
    import Para from "$lib/components/Para.svelte";
    import Sect from "$lib/components/Sect.svelte";
    import Heading from "$lib/components/Heading.svelte";
    import { toast } from "svelte-sonner";
    let serverIp = "teamsmp.spdns.eu:33221";

    function copyIpToClipboard() {
        navigator.clipboard
            .writeText(serverIp)
            .then(() => {
                console.log("Copied server IP to clipboard: ", serverIp);
                toast.success("Copied server IP to clipboard!");
            })
            .catch((error) => {
                console.error("Failed to copy server IP: ", error);
                toast.error("Error copying server IP to clipboard", {
                    description: "Check console for more details",
                });
            });
    }
</script>

<svelte:head>
    <title>Join &bull; Team SMP</title>
</svelte:head>

<MainBlock>
    <TitleBlock title="Join" subtitle="TEAM SMP" />

    <div id="maintext">
        <Para lead
            >Want to join the Team SMP? Follow these instructions and you'll be
            on in no time!</Para
        >

        <Sect sectid="step1">
            <Heading htype="macro">1. Add the server IP</Heading>
            <Para>
                Add the following IP to your server list in Minecraft by
                clicking "add server" and typing it into the "server address"
                box.
            </Para>
            <div class="mb-2 flex flex-row gap-1">
                <code
                    class="rounded-s-md bg-zinc-200 px-3 py-2 dark:bg-zinc-800"
                    >{serverIp}</code
                >
                <button
                    class="rounded-e-md bg-zinc-200 px-3 py-2 text-zinc-700 hover:bg-zinc-300 dark:bg-zinc-800 dark:text-zinc-400 hover:dark:bg-zinc-700"
                    on:click={copyIpToClipboard}>Copy</button
                >
            </div>
        </Sect>

        <Sect sectid="step2">
            <Heading htype="macro">2. Join the server</Heading>
            <Para>
                Now you actually have to join the server. Press "done" and
                double-click on the new entry in the server list. Once joining,
                you will be asked to download a resource pack automagically.
                Simply accept the request and wait for it to complete the
                download.
            </Para>
        </Sect>

        <Sect sectid="step3">
            <Heading htype="macro">3. After joining</Heading>
            <Para>
                Now that you're in the server, you will spawn in the Lobby <a
                    class="underline hover:text-sky-500"
                    href="https://best-friends.gitbook.io/team-smp/the-lobby"
                    ><i>(wiki)</i></a
                >. The Guide NPC will tell you everything you need to know to
                get into the survival world, but in short, either walk forwards
                to the big portal or right click on the Game Menu NPC to your
                left.
            </Para>
        </Sect>

        <Para>We hope you have fun playing on the Team SMP!</Para>
    </div>
</MainBlock>
