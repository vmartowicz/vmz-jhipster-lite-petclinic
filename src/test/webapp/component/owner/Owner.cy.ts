import { dataSelector } from '../utils/DataSelector';

describe('Owner Component', () => {
  it('should display owner details', () => {
    cy.visit('/owners/details/716d28f5-fb62-4a7f-9ce0-360d1893aed5'); // Adjust the URL to match your routing

    // Check if the owner details are displayed
    cy.get(dataSelector('owner-loader'))
      .should('be.visible')
      .then(() => {
        cy.get(dataSelector('owner')).should('not.exist');

        cy.get(dataSelector('owner-recipient.name')).should('contain', 'John Doe');
        cy.get(dataSelector('owner-recipient.address.street')).should('contain', '123 Main St');
        cy.get(dataSelector('owner-recipient.address.city')).should('contain', 'Anytown');
        cy.get(dataSelector('owner-recipient.address.zipCode')).should('contain', '12345');
        cy.get(dataSelector('owner-recipient.phone')).should('contain', '123-456-7890');
      });
  });
  it('should handle error', () => {
    cy.visit('/owners/details/35e8d3e4-4c26-403d-815e-71262901481a');
    cy.get(dataSelector('owner-error')).should('be.visible');
  });
});
