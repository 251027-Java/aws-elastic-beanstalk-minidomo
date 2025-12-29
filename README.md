[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/yVXgyjQD)
# Lab: Deploy to AWS Elastic Beanstalk

## Goal
Deploy a Spring Boot application to AWS Elastic Beanstalk.

## Learning Objectives
- Package a Spring Boot application for deployment
- Create an Elastic Beanstalk environment
- Configure environment variables
- Monitor application health

## Pre-requisites
- AWS Account
- Spring Boot application (provided)
- Maven installed

## Tasks

### Task 1: Prepare the Application
1. Navigate to the starter code directory
2. Build the JAR file:
   ```bash
   mvn clean package
   ```
3. Verify the JAR in `target/` directory

### Task 2: Create Elastic Beanstalk Application
1. Go to AWS Console → Elastic Beanstalk
2. Click "Create application"
3. Configure:
   - **Application name**: `spring-eb-lab`
   - **Platform**: Java
   - **Platform branch**: Corretto 17
   - **Platform version**: Latest
4. Upload your JAR file
5. Click "Create application"

### Task 3: Wait for Environment Creation
- Watch the events log
- Wait for "Environment health has transitioned to Ok"
- Note the environment URL

### Task 4: Test the Application
```bash
# Health check
curl http://<your-eb-url>/actuator/health

# Hello endpoint
curl http://<your-eb-url>/hello
```

### Task 5: Configure Environment Variables
1. Go to Configuration → Software → Edit
2. Add environment properties:
   ```
   APP_MESSAGE=Hello from Elastic Beanstalk!
   SPRING_PROFILES_ACTIVE=prod
   ```
3. Apply changes

### Task 6: View Logs
1. Go to Logs → Request Logs → Last 100 lines
2. Look for your application startup logs
3. Identify any errors

### Task 7: Clean Up (Important!)
1. Go to Environments
2. Select your environment
3. Actions → Terminate environment
4. Delete the application

## Bonus: EB CLI
If you have EB CLI installed:
```bash
# Initialize
eb init -p java-17 spring-eb-lab

# Create environment
eb create production

# Deploy
eb deploy

# Open in browser
eb open

# View logs
eb logs

# Terminate
eb terminate
```

## Deliverables
1. Screenshot of running environment
2. Screenshot of successful health check
3. Environment URL
4. Screenshot of termination confirmation

## Starter Code
See `starter_code/` for a simple Spring Boot application
