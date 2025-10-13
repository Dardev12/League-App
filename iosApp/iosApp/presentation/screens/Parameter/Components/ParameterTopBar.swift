//
//  ParameterTopBar.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ParameterTopBar: View {
    @Environment(\.colorScheme) var colorScheme
    @Binding var selection: String?
    
    var body: some View {
        HStack{
            Spacer()
            Text(
                IosStringResources(id:SharedRes.strings().parameter_text_button,args:[])
            ).font(.custom(.h2Large))
                .foregroundColor(Color.textColor)
            Spacer()
            
        }.padding(.horizontal, 20)
            .padding(.top, 45)
    }
}
