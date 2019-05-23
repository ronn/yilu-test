Yilu Senior Backend Developer


3. What is a sum type? What is a product type?
- Both concepts come from Algebraic data types wich are types that represent data that have properties from algebra such as ditributibity, conmutativity, identities, ETC.



Product Type is the representation of different types together in one.
A good example for this in java could be a POJO.
For example we can have the type Person, but it's made out with several types inside like a String for the name, an Integer for the age and so on.
In other languages exist structures like Tuple.

A Sum Type is the representation of a single final value even if it has several options to choice
Best example could be Boolean type wich coulbe either true or false but not both
There are some other examples like Optional wich could be an instance of Some or None (depending on the language)

4. What does reduce do? map? flatMap? Give one simple example for each one.

All of them are High Order Functions

given const list = [1, 2, 3, 4, 5]

.reduce(): Combines all the elements of an object and returns its single combined value applying a given function as a parameter
If we want to reduce all the list values to the sum of all of them we can use the reduce function like this:

		list.reduce((a, b) => a + b)

.map(): Take each element that exist in the object and tanform it by applying the given function and return the same object with the new values A => B

we can "tranform" list to a new array with it's elements multiplied by 2 using map

		list.map(x => x * 2)
This will return [2, 4, 6, 8, 10]

.flatMap: Applies the .map() function and then flattens the nested objects 1 level in a single one of the same type A => O[B]
 
if we have 
	const list = [[1, 2, 3], [4, 5]]
and we want all the values multiplied by 2 but in a single list we can use flatMap like this:

	list.flatMap(x => x.map(y => y * 2))


5. We need to build an app for a restaurant that allows a user to register, login, book a table, get a QR-code, send a notification 1 hour before the reservation, show and scan the QR code to validate the reservation, pay (after eating of course) and rate the reservation after the user has payed.
a. Which microservices can you identify?


- Booking: will manage the reservations and will trigger a notification 1 our before
	and propagate the reservations to other microservices
- Codes: Will listen the booking and generate the QR code. This ms will be able as well to read QR codes and validate them to propagate the arrival

- Payment: Will listen the client arrival to enable, register and manage the payments for clients and will propagate the payment
- Rating: Will listen the payment event and will anable the posibility to rate the reservation

b. Where would you store your data? Explain your choices.
A database for persisting the data and if it's possible propagate projections to a DB for reading



6. What is CAP? What does it mean?

Consistency: Every read receives the most recent write or an error
Availability: Every request receives a (non-error) response – without the guarantee that it contains the most recent write
Partition tolerance: The system continues to operate despite an arbitrary number of messages being dropped (or delayed) by the network between nodes

There is a theorem that says