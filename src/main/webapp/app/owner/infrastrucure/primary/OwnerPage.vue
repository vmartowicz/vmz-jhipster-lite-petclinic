<script setup lang="ts">
import { inject } from '@/injections';
import { OWNERS_REPOSITORY } from '@/owner/application/OwnersKeys';
import type { Owner } from '@/owner/domain/Owner';
import OwnerDetails from '@/owner/infrastrucure/primary/OwnerDetails.vue';
import OwnerError from '@/owner/infrastrucure/primary/OwnerError.vue';
import OwnerLoader from '@/owner/infrastrucure/primary/OwnerLoader.vue';
import { Loader } from '@/shared/loader/infrastructure/primary/Loader';
import { onMounted, ref } from 'vue';

const owner = ref(Loader.loading<Owner>());
const owners = inject(OWNERS_REPOSITORY);

const props = defineProps({
  id: {
    type: String,
    required: true,
  },
});

onMounted(() => {
  owners
    .get(props.id)
    .then(result => (owner.value = Loader.loaded(result)))
    .catch(error => (owner.value = Loader.error(error)));
});
</script>

<template>
  <owner-loader v-if="owner.isLoading" />
  <owner-details v-else-if="owner.isLoaded" :owner="owner.value" />
  <owner-error v-else-if="owner.isInError" />
</template>
