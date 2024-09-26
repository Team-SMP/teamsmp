<script>
    import NavNew from "$lib/components/NavNew.svelte";
    import "../app.css";
    import { Toaster } from "$lib/components/ui/sonner";
</script>

<Toaster richColors closeButton theme="dark" />

<div class="min-h-screen">
    <NavNew></NavNew>
    <slot></slot>
</div>
