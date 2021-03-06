[![Contributors][contributors-shield]][contributors-url]
[![LinkedIn][linkedin-shield]][linkedin-url]


<!-- ABOUT THE PROJECT -->
## About The Project

This is a single page using Java and Spring framework with thymeleaf which uses a SQLite database.

The database has Customer table which contains:
* id (0)
* name ("Abdelaziz Said")
* phone ("(212) 698054317")

I need to Categorize this phone number by:
* Country Name
* State (The Number is Valid or not. So if it's true that mean the number is valid, and if not which means that the number doesn't related to this country)
* Country Code
* Phone Number



## Steps to Use the Project
1. Install the SQLite into your localhost.
2. Add dummy data into customer table.
3. Open the browser into this url [https://localhost:8080/customer/categorize/](https://localhost:8080/customer/categorize/)


This will show you the Required Page which contains a table with:
* Country Name
* State
* Country Code
* Phone Number


## Steps to create docker image:
1. Install the docker into your machine from this site [https://docs.docker.com/engine/install/](https://docs.docker.com/engine/install/)
2. Run this maven goal _**mvn spring-boot:build-image**_ to create the image without the Dockerfile (if you work with linux try to run it with the admin)
3. Run this command to run the docker image _**sudo docker run -p 8080:8080 demo:0.0.1-SNAPSHOT**_
4. Ensure that the image has been run by this command _**sudo docker ps -a**_, you will find the image name, container id and some other options
5. Open the browser into this url [https://localhost:8080/customer/categorize/](https://localhost:8080/customer/categorize/)


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/AbdelazizSaid250
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/abdelaziz-said-4a9b12127