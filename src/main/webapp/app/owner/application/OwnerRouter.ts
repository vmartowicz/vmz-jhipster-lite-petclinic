import OwnerPage from '@/owner/infrastrucure/primary/OwnerPage.vue';
import type { RouteRecordRaw } from 'vue-router';

export const ownerRoutes = (): RouteRecordRaw[] => [
  {
    path: '/owners/details/:id',
    name: 'Owner',
    component: OwnerPage,
    props: true,
  },
];
