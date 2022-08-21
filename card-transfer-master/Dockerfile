FROM node:12
WORKDIR /app
ADD package*.json ./
RUN npm install
COPY . .
EXPOSE 3000
ENTRYPOINT ["npm", "run", "start"]