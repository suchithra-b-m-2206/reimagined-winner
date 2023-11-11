nstall Express==➔ npm install express

Install JSON==➔npm install json

Install JOI=➔npm install joi or npm install @hapi/joi

const express = require('express');

const Joi = require('@hapi/joi'); //used for validation

const app = express();

app.use(express.json());

const movies = [

{title: 'KGF', id: 1},

{title: 'RRR', id: 2},
title: 'James', id: 3}

]

//***********READ Request Handlers****************

app.get('/', (req, res) => {

res.send('Welcome to REST API with Node.js!!');

});

app.get('/movies', (req,res)=> {

res.send(movies);

});

app.get('/movies/:id', (req, res) => {

const getmovie = movies.find(c => c.id === parseInt(req.params.id));

if (!getmovie) res.status(404).send('<h2 style="font-family: Malgun Gothic; 

color: darkred;">Ooops... Cant find what you are looking for!</h2>');

res.send(getmovie);

});

//*************CREATE Request Handler**********

app.post('/movies', (req, res)=> {

const { error } = validateMovie(req.body);

if (error){

res.status(400).send(error.details[0].message)

return;

}

const getmovie = {

id: movies.length + 1,

title: req.body.title

};

movies.push(getmovie);

res.send(getmovie);

});

//UPDATE Request Handler

app.put('/movies/:id', (req, res) => {

const movie = movies.find(c=> c.id === parseInt(req.params.id));

if (!movie) res.status(404).send('Not Found!!');

const { error } = validateMovie(req.body);

if (error){

res.status(400).send(error.details[0].message);

return;

}
movie.title = req.body.title;

res.send(movie);

});

//DELETE Request Handler

app.delete('/movies/:id', (req, res) => {

const getmovie = movies.find( c=> c.id === parseInt(req.params.id));

if(!getmovie) res.status(404).send(' Not Found!!');

const index = movies.indexOf(getmovie);

movies.splice(index,1);

res.send(getmovie);

});

function validateMovie(getmovie) {

const schema = {

title: Joi.string().min(3).required()

};

return Joi.validate(getmovie, schema);

}

//PORT ENVIRONMENT VARIABLE

const port = process.env.PORT || 8080;

app.listen(port, () => console.log(`Listening on port ${port}..`));
