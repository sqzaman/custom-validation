# custom-validation
SpringBoot Custom Validation based on Custom Annotation

Let's say I have to write a rest api for searching movies from some movies data source, 
I want to serach based on movies release date. But I dont know exact release date of a movie that I am seraching for. 
So I decided to make it seacrhable from a date range, again if the range is very big then return list will be very big and the tons of user is concurrently searching using a very big date range, I might have resounce problem in my server. 

Then I decided to impose a validation rule on the search crieteria. maximum search range can be 7 days or so, between a provided  start date and end date.
