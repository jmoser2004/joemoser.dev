import {React, useState} from "react";
import BackHeader from "../header/BackHeader";
import {pdfjs, Document, Page} from "react-pdf";
import JoeResume from "./Joe_Moser_Resume.pdf";
import "./resume.css";

pdfjs.GlobalWorkerOptions.workerSrc = new URL('pdfjs-dist/build/pdf.worker.min.mjs', import.meta.url).toString();


function Resume() {
    return (
        <>
            <div>
                <BackHeader />
                <div className="pdf">
                    <h5>NOTE: Page may not render correctly on mobile devices</h5>
                    <Document file={JoeResume}>
                        <Page pageNumber={1} renderTextLayer={false} renderAnnotationLayer={false}/>
                    </Document>
                </div>
                <div className="download">
                    <a href={JoeResume} download>Download</a>
                </div>
            </div>
        </>
    )
}

export default Resume