# Code Samples

This code sample calculates the maximum order limit for a customer. The maximum order limit defines how many open orders total a customer can have (Standard)
or how many new orders are placed on a sliding period of time (Rolling). The type of calculation is configurable per customer and can only be one of the 2 pre-defined types.
The rolling type has been introduced to limit how many orders a customer can place in a certain period of time and to reduce fraudulent activity.

## Example

```java
AbstractResult molResult = molService.performMolCalculation(customer, order);
KickOutReasonModel molKickOutReason = molResult.performCheck();
if (molKickOutReason != null) {
    // Do something with the error...
}
```

## Note

The model package has been added for compilation reason.