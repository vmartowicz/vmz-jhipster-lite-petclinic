import { provide } from '@/injections';
import { OWNERS_REPOSITORY } from '@/owner/application/OwnersKeys';
import { InMemoryOwnersRepository } from '@/owner/infrastrucure/secondary/InMemoryOwnersRepository';

export const providerForOwners = (): void => {
  provide(OWNERS_REPOSITORY, new InMemoryOwnersRepository());
};
