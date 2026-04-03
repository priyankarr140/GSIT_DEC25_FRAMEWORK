@addCart
Feature: Validate add to cart functionality 

  Scenario: Validate add to cart feature when user has cleared filters
   Given user is on the search page and clear filter is applied
	When user search flower "Rose" and quantity "3"
	Then validate correct item is added 
	And  validate correct item quantity

	