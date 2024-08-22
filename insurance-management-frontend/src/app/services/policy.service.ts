import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {
  private apiUrl = 'http://localhost:8080/api/policies';

  constructor(private http: HttpClient) {}

  getAllPolicies(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  addPolicy(policy: any): Observable<any> {
    return this.http.post(this.apiUrl, policy);
  }
}
