import type { OwnerId } from '@/owner/domain/OwnerId';
import type { Recipient } from '@/owner/domain/Recipient';

export type Owner = {
  id: OwnerId;
  recipient: Recipient;
};
