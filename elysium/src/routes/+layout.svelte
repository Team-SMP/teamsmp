<script>
    import Nav from "$lib/components/Nav.svelte";
    import "../app.css";
</script>

<div class="min-h-screen text-lg dark:bg-zinc-950 dark:text-white">
    <Nav></Nav>
    <slot></slot>
</div>
