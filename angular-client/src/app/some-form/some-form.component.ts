import { Component, OnInit } from "@angular/core";
import { SomeBean } from '../SomeBean';

@Component({
  selector: "app-some-form",
  templateUrl: "./some-form.component.html",
  styleUrls: ["./some-form.component.css"]
})
export class SomeFormComponent implements OnInit {
  
  urlPath: string = "http://localhost:8080/resteasy/rest/some/pdf";

  paramName: string = "objetJSON";

  someBean: SomeBean = {
    id: "deux",
    title: "un autre titre"
  }

  constructor() {}

  ngOnInit() {}
}
