<script>
    import Heading from "$lib/components/Heading.svelte";
    import MainBlock from "$lib/components/MainBlock.svelte";
    import Para from "$lib/components/Para.svelte";
    import Sect from "$lib/components/Sect.svelte";
    import TitleBlock from "$lib/components/TitleBlock.svelte";
</script>

<svelte:head>
    <title>Home &bull; Team SMP</title>
</svelte:head>

<MainBlock>
    <!-- Title Block -->
    <TitleBlock title="Team SMP" subtitle="UNITE, SURVIVE, THRIVE!" />

    <!-- Main Text Content -->
    <div id="maintext">
        <Para lead>
            The Team SMP is a survival Minecraft server run by XxDreamXxXx and
            JunglTemple.
        </Para>

        <!-- Unite Section -->
        <Sect sectid="unite">
            <Heading htype="macro">UNITE</Heading>
            <Para>
                Unite with your friends in a team! Together, you'll build
                amazing towns, explore new worlds, and defend your base from
                challenging raids. Whether you're gathering resources, designing
                epic builds, or taking on quests, teamwork is at the heart of
                the Team SMP experience.
            </Para>
            <Para>
                Join forces, create something incredible, and leave your mark on
                the server!
            </Para>
        </Sect>

        <!-- Survive Section -->
        <Sect sectid="survive">
            <Heading htype="macro">SURVIVE</Heading>
            <Para>
                Face the wilderness head-on and test your survival skills! On
                the Team SMP, danger lurks around every corner, from hostile
                mobs to harsh environments. Gather resources, build shelter, and
                fend off threats as you navigate the unpredictable world around
                you.
            </Para>
            <Para>Do you have what it takes to survive?</Para>
        </Sect>

        <!-- Thrive Section -->
        <Sect sectid="thrive">
            <Heading htype="macro">THRIVE</Heading>
            <Para>
                Once you've mastered survival, it's time to thrive! Build
                sprawling bases, start your own economy, and shape the world
                around you. Team up with others or go solo as you rise to the
                top of the Team SMP community, leaving a lasting legacy in the
                server's ever-changing landscape.
            </Para>
            <Para>Survive the night, thrive in the day!</Para>
        </Sect>
    </div>
</MainBlock>
