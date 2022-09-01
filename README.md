# Endpoints Documentation
* Swagger UI: http://localhost:8080/swagger-ui/index.html
* GET /api/chatbot/{userId}/create-session => Creates a user sessionId and returns it with the bot's greetings message 
* POST /api/chatbot/{userId}/chat => Takes the student's messages and its sessionId and return the bot's response to the student's message
* POST /api/meeting => Takes a meetingRecord as json Body and saves it to the database
* GET /api/meeting => Return all the meetingRecords
* GET /api/meeting/student/{studentId} => Returns all the meetingRecords for that student
* GET /api/meeting/doctor/{doctorId} => Returns all the meetingRecords for that doctor

# Configuration 
To change the bot used for the chat the next values need to be modified
* ibm.api.key: Key found on the IBM Cloud Assistant Service 
* imb.api.key: url found on the IBM Cloud Assistant Service
* ibm.assistant.id: ID for one of the bots inside the IBM Cloud Assistant Service (One instance of the service can manage multiple bot)
