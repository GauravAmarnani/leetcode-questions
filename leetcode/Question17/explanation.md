# Explanation: Best Time to Buy and Sell Stock

## Problem Statement

Given an array `prices`, where `prices[i]` is the price of a stock on the `i`-th day, you are tasked with finding the maximum profit you can achieve by buying on one day and selling on a later day. If no profit can be made, return `0`.

### Example:

- **Input**: `prices = [7,1,5,3,6,4]`
- **Output**: `5`
- **Explanation**: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.

- **Input**: `prices = [7,6,4,3,1]`
- **Output**: `0`
- **Explanation**: In this case, no transactions can be made for a profit, so the result is `0`.

---

## Approach

The problem can be solved efficiently using a **greedy approach**. Here's the step-by-step reasoning:

1. **Initialization**:
   - Keep track of the **minimum price** encountered so far (`buy`), initialized to `Integer.MAX_VALUE`.
   - Keep track of the **maximum profit** (`sell`), initialized to `0`.

2. **Iterate through the array**:
   - For each price:
     - Update the `buy` price as the minimum of the current `buy` and the current price (`prices[i]`).
     - Calculate the potential profit if the stock is sold on the current day: `prices[i] - buy`.
     - Update the `sell` (maximum profit) if this profit is greater than the current `sell`.

3. **Return the maximum profit**.

### Time Complexity:
- **O(n)**: We iterate through the array once, making this solution efficient even for large inputs (up to `10^5`).

### Space Complexity:
- **O(1)**: We use only a constant amount of extra space.

---

## Code Implementation

```java
class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, sell = 0;
        for (int i = 0; i < prices.length; i++) {
            // Update the minimum price (buy price)
            buy = Math.min(buy, prices[i]);
            // Calculate the profit if we sold at the current price
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }
}
```

---

## Explanation:

1. **Initialization**:
   - We start by setting `buy` to a very high value (`Integer.MAX_VALUE`) to ensure that the first price encountered will always be smaller than `buy`.
   - `sell` is initialized to `0`, as initially, no profit is made.

2. **Loop through prices**:
   - For each price in the list:
     - Update `buy` to be the smaller of the current price and the previously encountered `buy` price.
     - Calculate the profit for selling at the current price by subtracting `buy` from the current price. Update `sell` to the maximum of the current `sell` and this calculated profit.

3. **Return the result**:
   - After processing all the prices, `sell` will contain the maximum profit.

---

## Example Walkthrough

### Example 1: `prices = [7,1,5,3,6,4]`

- Initially, `buy = Integer.MAX_VALUE`, `sell = 0`.
- Day 1: Price = 7 → `buy = 7`, `sell = 0`.
- Day 2: Price = 1 → `buy = 1`, `sell = 0`.
- Day 3: Price = 5 → `buy = 1`, `sell = 4` (profit = 5 - 1).
- Day 4: Price = 3 → `buy = 1`, `sell = 4` (no profit increase).
- Day 5: Price = 6 → `buy = 1`, `sell = 5` (profit = 6 - 1).
- Day 6: Price = 4 → `buy = 1`, `sell = 5` (no profit increase).

The maximum profit is `5`, which is returned.

### Example 2: `prices = [7,6,4,3,1]`

- Initially, `buy = Integer.MAX_VALUE`, `sell = 0`.
- Day 1: Price = 7 → `buy = 7`, `sell = 0`.
- Day 2: Price = 6 → `buy = 6`, `sell = 0`.
- Day 3: Price = 4 → `buy = 4`, `sell = 0`.
- Day 4: Price = 3 → `buy = 3`, `sell = 0`.
- Day 5: Price = 1 → `buy = 1`, `sell = 0`.

Since no transaction yields a profit, the result is `0`.

---

## Conclusion

The solution efficiently computes the maximum possible profit with a time complexity of **O(n)** by keeping track of the minimum price encountered so far and calculating potential profits as we iterate through the list. This approach ensures that we only make one pass through the prices, which is optimal for this problem.
