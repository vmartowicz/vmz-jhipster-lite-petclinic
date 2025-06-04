import type { City } from '@/owner/domain/City';
import type { Street } from '@/owner/domain/Street';
import type { ZipCode } from '@/owner/domain/ZipCode';

export type Address = {
  street: Street;
  city: City;
  zipCode: ZipCode;
};
