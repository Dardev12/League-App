//
//  BoxRemoveUserPopUp.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct BoxRemoveUserPopUp: View {
    var eventRemoveUserClick: ()  -> Void
    var eventCancelClick: ()  -> Void
    
    var body: some View {
        ZStack{
            Color.background.ignoresSafeArea().opacity(0.8)
            
            HStack{
                ZStack{
                    RoundedRectangle(cornerRadius: 20)
                        .fill(Color.white)
                        .frame(width: 300, height: 200)
                        .shadow(radius: 2)
                    VStack(alignment: .center){
                        Text(IosStringResources(id: SharedRes.strings().confirm_delete_account, args: []))
                            .font(.custom(.pBody))
                            .foregroundColor(Color.errorColor)
                            .frame(width:260,alignment: .center)
                        HStack(alignment: .center) {
                            Spacer()
                            
                            Spacer()
                        }
                    }.frame(alignment: .center)
                }
            }.padding(8)
            .background(Color.clear)
        }
    }
}
