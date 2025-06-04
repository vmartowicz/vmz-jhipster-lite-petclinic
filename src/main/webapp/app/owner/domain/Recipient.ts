import type { Address } from '@/owner/domain/Address';
import type { Name } from '@/owner/domain/Name';
import type { Phone } from '@/owner/domain/Phone';

export type Recipient = {
  name: Name;
  address: Address;
  phone: Phone;
};
