import { BaseModel } from '../shared/module/base.model';

export class EventListAllModel extends BaseModel{
  eventId: number;
  duration: string;
  participants: number;
  eventDate:string;
  comissars:ComissarsModel[];
}

export class ComissarsModel{
  commissarId:number;
  name:string;
  typeId:string;
}

export class commissarModel{
  id:Int16Array;
  name:string;
}