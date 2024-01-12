import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { HttpClientModule } from "@angular/common/http";
import { MeatProductListComponent } from './meatProduct/view/meatProduct-list/meatProduct-list.component';
import { MeatProductService } from './meatProduct/service/meatProduct.service';
import { MeatProductViewComponent } from './meatProduct/view/meatProduct-view/meatProduct-view-component';
import { MeatProductEditComponent } from './meatProduct/view/meatProduct-edit/meatProduct-edit.component';
import { FormsModule } from "@angular/forms";
import {MeatTypeListComponent} from "./meatType/view/meatType-list/meatType-list.component";
import {MeatTypeEditComponent} from "./meatType/view/meatType-edit/meatType-edit.component";
import {MeatTypeViewComponent} from "./meatType/view/meatType-view/meatType-view-component";
import {MeatProductAddComponent} from "./meatProduct/view/meatProduct-add/meatProduct-add.component";
import {MeatTypeAddComponent} from "./meatType/view/meatType-add/meatType-add.component";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    MeatProductListComponent,
    MeatTypeListComponent,
    MeatTypeEditComponent,
    MeatProductViewComponent,
    MeatProductEditComponent,
    MeatTypeViewComponent,
    MeatProductAddComponent,
    MeatTypeAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    MeatProductService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
