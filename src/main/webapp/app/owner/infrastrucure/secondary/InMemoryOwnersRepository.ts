import { Optional } from '@/common/domain/Optional';
import type { Owner } from '@/owner/domain/Owner.ts';
import type { OwnerId } from '@/owner/domain/OwnerId.ts';
import type { OwnersRepository } from '@/owner/domain/OwnersRepository.ts';

const OWNER = {
  id: '716d28f5-fb62-4a7f-9ce0-360d1893aed5',
  recipient: {
    name: {
      firstname: 'John',
      lastname: 'Doe',
    },
    address: {
      street: '123 Main St',
      city: 'Anytown',
      zipCode: '12345',
    },
    phone: '123-456-7890',
  },
};

const OWNERS = new Map<OwnerId, Owner>([['716d28f5-fb62-4a7f-9ce0-360d1893aed5', OWNER]]);

export class InMemoryOwnersRepository implements OwnersRepository {
  get(id: OwnerId): Promise<Owner> {
    return Optional.ofNullable(OWNERS.get(id))
      .map(owner => this.toOwner(owner))
      .orElseGet(() => this.ownerNotFound(id));
  }

  private toOwner(owner: Owner): Promise<Owner> {
    return new Promise<Owner>(resolve => setTimeout(() => resolve(owner), 1000));
  }

  private ownerNotFound(id: string): Promise<Owner> {
    return Promise.reject(new Error(`"Owner ${id} not found"`));
  }
}
