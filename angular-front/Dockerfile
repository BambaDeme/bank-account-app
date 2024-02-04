# stage 1: Compile and build angular codebase

FROM node:latest as build

#Set working directory
WORKDIR /usr/local/app

#Add source code to the app directory
COPY ./ /usr/local/app

#install application dependencies
RUN npm install

#Generate the build of the application
RUN npm run build

# stage 2: Serve app with nginx server
FROM nginx:latest

# Copy the build output to replace the defaut nginx contents
COPY --from=build /usr/local/app/dist/angular-front-end/browser /usr/share/nginx/html

# Expose port 80
EXPOSE 80

