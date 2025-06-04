<template>
  <div data-selector="owner-recipient.name">{{ owner.recipient.name.firstname }} {{ owner.recipient.name.lastname }}</div>
  <div data-selector="owner-recipient.address.street">{{ owner.recipient.address.street }}</div>
  <div data-selector="owner-recipient.address.city">{{ owner.recipient.address.city }}</div>
  <div data-selector="owner-recipient.address.zipCode">{{ owner.recipient.address.zipCode }}</div>
  <div data-selector="owner-recipient.phone">{{ owner.recipient.phone }}</div>
</template>
<script setup lang="ts">
import type { Owner } from '@/owner/domain/Owner';
import type { PropType } from 'vue';

defineProps({
  owner: {
    type: Object as PropType<Owner>,
    required: true,
  },
});
</script>
