# Yilu Senior Backend Developer

**1. Write a function that accepts a string str and returns the first non-repeated character.**

[Solution](https://github.com/ronn/yilu-test/blob/master/src/main/java/YiluService.java) - getFirstNonRepeatedChar(String  str)

[Test](https://github.com/ronn/yilu-test/blob/master/src/test/java/YiluTest.java) - testGetFirstNonRepeatedChar()

**2. Write a function that accepts two strings (a) and (b) and answers true if (b) is a rotation of (a).**

[Solution](https://github.com/ronn/yilu-test/blob/master/src/main/java/YiluService.java) - isRotation(String  a, String  b)

[Test](https://github.com/ronn/yilu-test/blob/master/src/test/java/YiluTest.java) - testIsRotation()

**3. What is a sum type? What is a product type?**

Both concepts come from Algebraic data types which are types that represent data that have properties from algebra such as distributivity, commutativity, identities, ETC.

- Product Type is the representation of different types together in one.
A good example for this in java could be a POJO.
For example we can have the type Person, but it's made out with several types inside like a String for the name, an Integer for the age and so on.
In other languages exist structures like Tuple.

- A Sum Type is the representation of a single final value even if it has several options to choice
Best example could be Boolean type which could be either true or false but not both
There are some other examples like Optional which could be an instance of Some or None (depending on the language)

**4. What does reduce do? map? flatMap? Give one simple example for each one.**

All of them are High Order Functions.
Given:
```javascript
const list = [1, 2, 3, 4, 5]
```

***.reduce():*** Combines all the elements of an object and returns its single combined value applying a given function as a parameter
If we want to reduce all the list values to the sum of all of them we can use the reduce function like this:

```javascript
list.reduce((a, b) => a + b)
```

***.map():*** Take each element that exist in the object and transform it by applying the given function and return the same object with the new values. A => B

we can "transform" list to a new array with its elements multiplied by 2 using map
```javascript
list.map(x => x * 2)
```		
This will return `[2, 4, 6, 8, 10]`

***.flatMap():*** Applies the .map() function and then flattens the nested objects 1 level in a single one of the same type A => O[B]
 
if we have:
```javascript
const list = [[1, 2, 3], [4, 5]]
```
and we want all the values multiplied by 2 but in a single list we can use .flatMap() like this:
```javascript
list.flatMap(x => x.map(y => y * 2))
```

**5. We need to build an app for a restaurant that allows a user to register, login, book a table, get a QR-code, send a notification 1 hour before the reservation, show and scan the QR code to validate the reservation, pay (after eating of course) and rate the reservation after the user has payed:**

**a. Which microservices can you identify?**


- **Booking**: will manage the reservations and will trigger a notification 1 our before
	and propagate the reservations to other microservices
- **Codes**: Will listen the booking and generate the QR code. This ms will be able as well to read QR codes and validate them to propagate the arrival

- **Payment**: Will listen the client arrival to enable, register and manage the payments for clients and will propagate the payment
- **Rating**: Will listen the payment event and will enable the possibility to rate the reservation

**b. Where would you store your data? Explain your choices.**

A database for persisting the data and if it's possible propagate projections to a DB for reading