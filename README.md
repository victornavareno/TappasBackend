![image](https://github.com/user-attachments/assets/21f2039d-3013-4d75-a501-3639cb56d75c)
A backend application developed in Spring Boot. It imports real restaurant updated data from a dataset, formats and exposes it through a REST API connected to MongoDB. It also implements a Redis cache to minimize LFU connections and response time.

Its purpose is to make it easier for users to find the best restaurants based on their city and the dish they want to eat.

---

## Databases
The API connects to a non-relational MongoDB database running in a Docker container, which is loaded with the dataset of restaurants in the region of your choice.



### Redis: Performance Optimization
Additionally, Tappas integrates Redis as a caching system to speed up the most frequent responses, such as:

- Repeated queries by city and dish.

- Top 3 restaurant priorization algorithm based on user reviews.

- Precaching popular searches based on user usage patterns.

---

<img width="850" height="500" alt="image" src="https://github.com/user-attachments/assets/5e200ef8-7664-4d1a-98b6-0dea71b3e314" />


## Victor Navareño
