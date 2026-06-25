# Tappas Backend
![image](https://github.com/user-attachments/assets/21f2039d-3013-4d75-a501-3639cb56d75c)
Tappas is a backend application developed in Spring Boot. It imports updated data from a dataset containing all the restaurants in Extremadura, Spain, and exposes it through a REST API connected to MongoDB. It also implements a Redis cache to minimize LFU connections and response time.

Its purpose is to make it easier for users to find the best restaurants based on their city and the dish they want to eat.

---

### Databases
The API connects to a non-relational MongoDB database running in a Docker container, which is loaded with the dataset of restaurants in the region of your choice.



### Redis: Performance Optimization
Additionally, Tappas integrates Redis as a caching system to speed up the most frequent responses, such as:

- Repeated queries by city and dish.

- Top 3 restaurant priorization algorithm based on user reviews.

- Precaching popular searches based on user usage patterns.

---

### Restaurant Podium Feature Preview
<img width="550" height="400" alt="tappas by Victor Navareño" src="https://github.com/user-attachments/assets/6232712b-f253-44a6-883b-f2e0bdaa7ecd" />

## by Victor Navareño
