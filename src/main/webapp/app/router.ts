import { homeRoutes } from '@/home/application/HomeRouter';
import { ownerRoutes } from '@/owner/application/OwnerRouter.ts';
import { createRouter, createWebHistory } from 'vue-router';

export const routes = [...homeRoutes(), ...ownerRoutes()];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
