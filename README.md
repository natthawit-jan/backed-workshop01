# List of test cases 

[TC 1, 2, 3](#test-case-1-2-and-3)

[TC4](#test-case-4)

[TC5](#test-case-5)

[TC6](#test-case-6)

## Test Case 1, 2 and 3       
`5638882  The first three commit`


## Test case 4  
`dcb1a77e -  TC4 ` 

Test Description: The write pointer should able to go back the first position when it reaches the end of the buffer size.  

Testing steps         
- Set Up : Add The first 4 Elements    `[A0, A1, A2, A3, _]`

-  The first read should get 'A0' (Now, the read pointer is at A1, the write pointer is at the end the pointer)

-  write A4 and B0   `[B0,A1, A2, A3, A4]`

- reading data 5 times should get to B0 

## Test case 5 
`93237f0d - TC5`

Read data should linearly be correct 

## Test Case 6  
`1289212d - TC6`

The old data will be evicted if not read and the buffer is full
