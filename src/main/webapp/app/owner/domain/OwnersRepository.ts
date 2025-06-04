import type { Owner } from '@/owner/domain/Owner';
import type { OwnerId } from '@/owner/domain/OwnerId';

export interface OwnersRepository {
  get(id: OwnerId): Promise<Owner>;
}
