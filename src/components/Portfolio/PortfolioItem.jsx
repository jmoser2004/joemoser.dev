import React from "react";
import "./portfolioItem.css";


function PortfolioItem({projectName, description, skillsLearned, githubLink, imageSource})
{
    const skillsList = skillsLearned.map((item) => <li key={item}>{item}</li>)

    return (
        <div className="itemBox">
            <div className="flex">
                <img src={imageSource} className="projectPhoto"></img>
                <div className="titleDesc">
                    <h2 className="itemTitle">{projectName}</h2>
                    <p className="descriptionParagraph">{description}</p>
                    <a href={githubLink} target="_blank" className="githubLink">Github Link</a>
                </div>
            </div>
            <ul className="skillsLearned">
                <h2>Skills learned:</h2>
                {skillsList}
            </ul>
        </div>
    );
}

export default PortfolioItem;