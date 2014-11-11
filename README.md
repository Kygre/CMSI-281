CMSI-281 - Assignment #4
========

I used interfaces to keep the implmentation simple. I did not really see a viable method to use abstract classess and have it be justifiable. Thus, I used an interface and had each Recent Collection implement Framework, the collection methods they all share. 
I decided to use an ArrayList on my third implementation, since it essentially represents an array in the background. As long as the initial capacity is set, since this recent collection has immutable size, then ArrayList has a bunch of cool features that makes life easy, like ListIterator. The ArrayList implementation is basically the RecentArray collection with different method calls to get and set the elements, which means if RecentArray works then RecentArrayList should work too.
