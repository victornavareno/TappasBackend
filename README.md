![image](https://github.com/user-attachments/assets/21f2039d-3013-4d75-a501-3639cb56d75c)



# Tappas Backend
Tappas is a backend application developed in Spring Boot that imports data from a dataset containing all the restaurants in Extremadura from an Excel file, and exposes it through a REST API connected to MongoDB. Its purpose is to make it easier for users to find the best restaurants based on their city and the dish they want to eat.

## Databases
![image](https://github.com/user-attachments/assets/dccb4269-5bfe-4ebe-927f-c32547682c0e)
Our API connects to a non-relational MongoDB database running in a Docker image, which is loaded with the dataset of restaurants in the region.



## Redis: Performance Optimization
Additionally, Tappas integrates Redis as a caching system to speed up the most frequent responses, such as:

- Repeated queries by city and dish.

- Top 3 restaurant podium results.

- Precaching of popular searches based on user usage patterns.

## Restaurant Podium Preview
<img width="500" height="400" alt="image" src="https://github.com/user-attachments/assets/6232712b-f253-44a6-883b-f2e0bdaa7ecd" />
