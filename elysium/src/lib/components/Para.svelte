<script>
    /**
     * @type {boolean}
     */
    export let lead = false;
</script>

<p class={lead ? "mb-4" : "mb-2"}>
    <slot>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer
        condimentum ante in ex aliquam, sit amet pellentesque ligula iaculis.
        Vestibulum augue nisl, egestas ac malesuada nec, aliquet id eros. Fusce
        eu tempus justo. Sed vel ultricies lorem. Cras efficitur velit lorem,
        sit amet luctus neque feugiat non. Praesent ac vehicula.
    </slot>
</p>
