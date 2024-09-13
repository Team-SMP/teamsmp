<script>
    import Emoji from "$lib/components/Emoji.svelte";
    import Heading from "$lib/components/Heading.svelte";
    import MainBlock from "$lib/components/MainBlock.svelte";
    import Para from "$lib/components/Para.svelte";
    import Sect from "$lib/components/Sect.svelte";
    import TitleBlock from "$lib/components/TitleBlock.svelte";
</script>

<svelte:head>
    <title>About Us &bull; Team SMP</title>
</svelte:head>

<MainBlock>
    <!-- Title Block -->
    <TitleBlock title="About Us" subtitle="TEAM SMP" />

    <!-- Main Text Content -->
    <div id="maintext">
        <Para lead>
            Hello there, friend! Here's what you need to know about the Team
            SMP.
        </Para>

        <div id="theteam">
            <Sect sectid="team-xxdream">
                <Heading htype="macro">XxDreamXxXx</Heading>
                <Para>
                    Hi. My name is XxDreamXxXx. I am the owner of the Team SMP.
                    Being the owner of the Team SMP means putting in hard work
                    and learning things all the time to make the Team SMP the
                    best we can possibly make it.
                </Para>
                <Para>
                    My main work is building big projects on the server like
                    lobby's and different minigame maps, but I also need to fund
                    things like buying plugins or upgrades to the Team SMP. I am
                    proud to be the head of such a great community, and I hope
                    that the Team SMP will go on to big things in the future.
                </Para>
                <Para>That's all from me - I hope to see you online soon.</Para>
            </Sect>
            <Sect sectid="team-jungl">
                <Heading htype="macro">JunglTemple</Heading>
                <Para>
                    Hi. I'm JunglTemple and I'm the Manager on the Team SMP. I
                    mostly handle the technical stuff but also try to take care
                    of what's happening on the server in general when XxDream is
                    doing other stuff.
                </Para>
                <Para>
                    I also do coding - <a
                        href="https://github.com/JunglTemple"
                        class="underline hover:text-sky-500"
                        >find me on GitHub</a
                    > - and I custom-coded this website that you're looking at right
                    now! I do a lot of random projects that rarely make it to the
                    publishing stage, but again, it's really a hobby.
                </Para>
                <Para>
                    So, that'll be it for me - I hope to see you online! <Emoji
                        >👋</Emoji
                    >
                </Para>
            </Sect>
        </div>
    </div>
</MainBlock>
