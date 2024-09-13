<script>
    import Heading from "./Heading.svelte";
    import Para from "./Para.svelte";

    export let sectid;
</script>

<section class="mb-4" id={sectid}>
    <slot>
        <Heading htype="macro"></Heading>
        <Para></Para>
    </slot>
</section>
