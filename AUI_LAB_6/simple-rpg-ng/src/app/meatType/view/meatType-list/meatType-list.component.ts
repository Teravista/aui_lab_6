import { Component, OnInit } from '@angular/core';
import { MeatTypeService } from "../../service/meatType.service";
import { MeatTypes } from "../../model/meatTypes";
import { MeatType } from "../../model/meatType";

@Component({
  selector: 'app-meatType-list',
  templateUrl: './meatType-list.component.html',
  styleUrls: ['./meatType-list.component.css']
})
export class MeatTypeListComponent implements OnInit{

  /**
   * @param service characters service
   */
  constructor(private service: MeatTypeService) {
  }

  /**
   * Available characters.
   */
  meatTypes: MeatTypes | undefined;

  ngOnInit(): void {
    this.service.getMeatTypes().subscribe(meatTypes => this.meatTypes = meatTypes);
  }


  onDelete(meatType: MeatType): void {
    this.service.daleteMeatTypes(meatType.id).subscribe(() => this.ngOnInit());
  }

}
