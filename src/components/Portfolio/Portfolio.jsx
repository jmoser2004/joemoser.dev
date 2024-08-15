import React from "react";
import BackHeader from "../header/BackHeader";
import PortfolioItem from "./PortfolioItem";
import "./portfolio.css"

import jm from "./images/joemoserdev.png";
import checklistifyPic from "./images/Checklistify.png";
import wWPic from "./images/wheresWatermelon.png";

function Portfolio() {
    return (
        <>
            <div>
                <BackHeader />
                <PortfolioItem projectName="joemoser.dev" description="Full stack multi-page website featuring a React frontend and a Springboot backend. Utilizes MongoDB Atlas, Axios, and the ChatGPT API." skillsLearned={["API Creation", "Springboot", "React", "MongoDB"]} githubLink="https://github.com/jmoser2004/joemoser.dev" imageSource={jm} />
                <PortfolioItem projectName="Checklistify" description="A chrome extension that consists of a simple checklist with ChatGPT integration. Features include adding, deleting, crossing out, and uncrossing items, as well as pasting or writing text in the ChatGPT textbox to allow ChatGPT to generate a checklist. Utilizes jQuery and the Fetch API." skillsLearned={["API usage", "Writing POST requests", "Writing Chrome extensions", "jQuery"]} githubLink="https://github.com/jmoser2004/checklistify" imageSource={checklistifyPic} />
                <PortfolioItem projectName="Where's Watermelon?" description="Small JavaScript application featuring the HTML Canvas element and events to create a small 'Where's Waldo'-like game." skillsLearned={["JavaScript", "Events", "HTML", "Canvas"]} githubLink="https://github.com/jmoser2004/Wheres-Watermelon" imageSource={wWPic} />
            </div>
        </>
    );
}

export default Portfolio;